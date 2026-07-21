package org.example.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name="question_id")
    @GeneratedValue(generator = "genrate_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name = "genrate_id",sequenceName = "question_id", initialValue = 1,allocationSize = 1)
    private int id;

    @Column(name = "question")
    private String Question;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    public Question(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
