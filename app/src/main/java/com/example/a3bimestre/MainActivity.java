package com.example.a3bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a3bimestre.adapter.AlunoListAdapter;
import com.example.a3bimestre.controller.AlunoController;
import com.example.a3bimestre.dao.AlunoDao;
import com.example.a3bimestre.modelo.Aluno;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edRaAluno;
    private EditText edNomeAluno;
    private ListView lvAlunos;
    private AlunoController controller;
    private ArrayList<Aluno> listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecao);

        edNomeAluno = findViewById(R.id.edNomeAluno);
        edRaAluno = findViewById(R.id.edRaAluno);
        lvAlunos = findViewById(R.id.lvAlunos);

        controller = new AlunoController(this);
        atualizaListaAlunos();

//      AlunoDao.getInstancia(this).getAll();


    }

    public void salvarAluno(View view) {
        if(validarDados()){
            Aluno aluno = new Aluno();
            aluno.setRaAluno(Integer.parseInt(edRaAluno.getText().toString()));
            aluno.setNomeAluno((edNomeAluno.getText().toString()));

            if (controller.salvarAluno(aluno) > 0){
                edRaAluno.setText("");
                edNomeAluno.setText("");
                atualizaListaAlunos();

            }else Toast.makeText(this,"Erro ao inserir Aluno",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void atualizaListaAlunos() {
        listaAlunos = new ArrayList<>();
        listaAlunos = controller.retornaAlunos();
        AlunoListAdapter adapter = new AlunoListAdapter
                (listaAlunos, this);

        lvAlunos.setAdapter(adapter);
    }


    public boolean validarDados(){

        if(edRaAluno.getText().toString().equals("")){
            edRaAluno.setError("Informe o RA do aluno");
            edRaAluno.requestFocus();
            return false;
        }
        if(edNomeAluno.getText().toString().equals("") ){
            edNomeAluno.setError("Informe o Nome do aluno");
            edNomeAluno.requestFocus();
            return false;
    }return true;

    }
}