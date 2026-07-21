package org.example.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @Column(name="answer_id")
    @GeneratedValue(generator = "genrate_ans_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name = "genrate_ans_id",sequenceName = "answer_id", initialValue = 1,allocationSize = 1)
    private int id;

    @Column(name = "answer")
    private String answer;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer(){};

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
