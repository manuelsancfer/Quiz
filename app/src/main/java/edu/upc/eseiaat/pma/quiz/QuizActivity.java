package edu.upc.eseiaat.pma.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;

public class QuizActivity extends AppCompatActivity {

    private int ids_answers[] = {  //tabla para pasar los id_ans
        R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView text_question = (TextView) findViewById(R.id.text_question); //seleccionar recuadro txt_question
        text_question.setText(R.string.question_content);   //escribir de string.xml el recurso creado(la pregunta)

        String[] answers = getResources().getStringArray(R.array.answers);  //obtener array de strings(las respuestas)


        for(int i=0; i<ids_answers.length; i++){
            RadioButton rb = (RadioButton) findViewById(ids_answers[i]);
            rb.setText(answers[i]); //escribe la respuesta en el radiobotón
        }


        final int correct_answer = getResources().getInteger(R.integer.correct_answers); //indicar respuesta buena
        final RadioGroup group = (RadioGroup) findViewById(R.id.answer_group); //obtener referencia al radiogroup


        Button btn_check = (Button) findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("manu","btn clickado");
                int id = group.getCheckedRadioButtonId();   // me dice cual es el que esta activado
                int answer = -1;
                for(int i=0; i<ids_answers.length; i++){
                    if(ids_answers[i]== id){    // cuando el array coincida con el activado
                        answer=i;               //escibirá la respuesta en answer(el índice)
                    }
                }

                if(answer == correct_answer){
                    Toast.makeText(QuizActivity.this, R.string.Correct, Toast.LENGTH_SHORT).show();
                }
                else if(answer == -1){
                    Toast.makeText(QuizActivity.this, R.string.Empty, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity.this, R.string.Incorrect, Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
