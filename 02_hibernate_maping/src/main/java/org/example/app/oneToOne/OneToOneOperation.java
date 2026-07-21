package org.example.app.oneToOne;

import org.example.CommonHooks.InputHooks;
import org.example.Model.Answer;
import org.example.Model.Question;
import org.example.db_hooks.GetSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToOneOperation {

    public static void main(String[] args) {
//        insertQuestionAndAnswer()
//        getQuestionById();
//        getAnswerById();
    }

    public static void insertQuestionAndAnswer(){
        String question= InputHooks.getStringValue("Enter the Question");
        String answer=InputHooks.getStringValue("Enter the answer");

        Session session=null;
        Transaction transaction=null;

        try{
            session= GetSessionFactory.getSessionFactory().openSession();
            transaction=session.beginTransaction();

            Question question1=new Question();
            question1.setQuestion(question);

            Answer answer1=new Answer();
            answer1.setAnswer(answer);
            answer1.setQuestion(question1);

            question1.setAnswer(answer1);

            session.persist(question1);
            session.persist(answer1);

            transaction.commit();
            System.out.println("operation success");

        }catch (HibernateException exception){
            exception.printStackTrace();
            System.out.println(exception.getMessage());
            transaction.rollback();
        }finally {

            session.close();
        }
    }

    public static void getQuestionById(){
        int questionid=InputHooks.getInputValue("Enter the question id");

        Session session=GetSessionFactory.getSessionFactory().openSession();

        Question question=session.find(Question.class,questionid);
        System.out.println("question : "+question.getQuestion()+ ", Answer : "+question.getAnswer().getAnswer());

    }

    public static void getAnswerById(){
        int answerId=InputHooks.getInputValue("Enter the answer id");

        Session session=GetSessionFactory.getSessionFactory().openSession();

        Answer answer=session.find(Answer.class,answerId);

        System.out.println("question : "+answer.getQuestion().getQuestion() + ", Answer : "+answer.getAnswer());
    }
}
