package com.example.japan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.japan.adapter.AnswerAdapter;
import com.example.japan.adapter.QuestionAdapter;
import com.example.japan.model.QuestionCourse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class fragment_home_learn_op2 extends Fragment {
    RecyclerView mRecyclerView, recyclerViewAnswer1;
    View view;
    int idQuestion;
    String result;
    ArrayList<String> wordCorrectList, wordWrongList, contentAnswerList,allWord, allWordWithoutRightAnswer;
    Map<String,CardView> cardViewsListFromQuestionAdapter;
    TextView txtQuestion2;
    Button btnCheck2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_learn_op2, container, false);
        wordCorrectList = new ArrayList<String>();
        contentAnswerList = new ArrayList<String>();
        cardViewsListFromQuestionAdapter = new HashMap<String, CardView>();
        anhxa();
        Bundle bundle = getArguments();
        if(bundle != null){
            idQuestion = bundle.getInt("idWord");
            String txtQuestion = bundle.getString("vnWord");
            txtQuestion2.setText(txtQuestion);
            result = bundle.getString("jWord");
            String[] arrayCorrectWord = result.split(" ");
            for(String word : arrayCorrectWord){
                wordCorrectList.add(word);
            }
        }
        createDataWord();
        getAllListWithoutRightAnswer();
        createWrongList();
        AnswerAdapter adapter2 = new AnswerAdapter(this, contentAnswerList);
        recyclerViewAnswer1.setAdapter(adapter2);
        QuestionAdapter adapter = new QuestionAdapter(this,wordWrongList);
        mRecyclerView.setAdapter(adapter);
        handleEventClickButtonCheck();
        return view ;
    }

    public void createDataWord(){
        allWord = (ArrayList<String>) ((Course) getActivity()).getALLStringCourse().clone();
    }

    public void createWrongList(){
        wordWrongList = new ArrayList<String>();
        for(String word : wordCorrectList){
            wordWrongList.add(word);
        }
        Random random = new Random();
        ArrayList<String> temp = (ArrayList<String>) allWordWithoutRightAnswer.clone();
        for(int i =0;i<3;i++){
            int rd = random.nextInt(temp.size());
            wordWrongList.add(temp.get(rd));
            temp.remove(rd);
        }
        mixList();
    }

    public void getAllListWithoutRightAnswer(){
        allWordWithoutRightAnswer = new ArrayList<String>();
        for (String s : allWord){
            if(!wordCorrectList.contains(s) || allWordWithoutRightAnswer.contains(s)){
                allWordWithoutRightAnswer.add(s);
            }
        }
    }

    public void mixList(){
        ArrayList<String> newList = new ArrayList<String>(wordWrongList);
        Random rand = new Random();
        for (int i = 0; i < newList.size(); i++) {
            int newPos = rand.nextInt(newList.size());
            while (newPos == i||newList.get(newPos)==null) {
                newPos = rand.nextInt(wordWrongList.size());
            }
            wordWrongList.set(i, newList.get(newPos));
            newList.set(newPos,null);
        }
    }
    public void anhxa(){
        txtQuestion2 = view.findViewById(R.id.txtQuestion2);
        btnCheck2 = view.findViewById(R.id.btnCheck2);
        mRecyclerView = view.findViewById(R.id.recyclerviewAnswer);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getContext(), 4);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        recyclerViewAnswer1 = view.findViewById(R.id.recyclerviewAnswer1);
        GridLayoutManager mGridLayoutManagerAnswer2 = new GridLayoutManager(getContext(), 4);
        recyclerViewAnswer1.setLayoutManager(mGridLayoutManagerAnswer2);
    }

    public void sendResult(String answer,CardView cardView){
        contentAnswerList.add(answer);
        cardViewsListFromQuestionAdapter.put(answer,cardView);

        AnswerAdapter adapter2 = new AnswerAdapter(this, contentAnswerList);
        recyclerViewAnswer1.setAdapter(adapter2);
    }

    public void returnAnswer(String answerRetrun){
        if(contentAnswerList.contains(answerRetrun)){
            contentAnswerList.remove(answerRetrun);
            AnswerAdapter adapter2 = new AnswerAdapter(this, contentAnswerList);
            recyclerViewAnswer1.setAdapter(adapter2);
            if(cardViewsListFromQuestionAdapter.containsKey(answerRetrun)){
                cardViewsListFromQuestionAdapter.get(answerRetrun).setVisibility(View.VISIBLE);
            }
        }
    }

    public void handleEventClickButtonCheck(){
        btnCheck2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkReuslt = contentAnswerList.equals(wordCorrectList);
                ((Course) getActivity()).showDialog(checkReuslt);
                if(checkReuslt){
                    ((Course)getActivity()).increaseProgressBar();
                    ((Course) getActivity()).removeRightQuestion(idQuestion);
                }
                if(((Course)getActivity()).randomQuestion() != null){
                    QuestionCourse questionCourse = ((Course)getActivity()).randomQuestion();
                    Bundle bundle = ((Course)getActivity()).createBundleToPass(questionCourse.getId(),questionCourse.getjWord(),questionCourse.getVnWord(),questionCourse.getImgWord());
                    Fragment fragment = ((Course)getActivity()).setFragment(questionCourse.getType());
                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_course, fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
    }
}