package Classes;

import java.util.Date;

public class Evaluation {
    private String id;
    private String employeeId;
    private String evaluatorId;
    private int score;
    private String comments;
    private Date evaluationDate;

    public Evaluation(String id, String employeeId, String evaluatorId, int score, String comments, Date evaluationDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.evaluatorId = evaluatorId;
        this.score = score;
        this.comments = comments;
        this.evaluationDate = evaluationDate;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEvaluatorId() {
        return evaluatorId;
    }

    public void setEvaluatorId(String evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}