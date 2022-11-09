package Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "task")
public class Task {

    public Task() { }

    public Task(Date startDatetime, int duration, String serviceType, String status, String comments) {
        this.startDatetime = startDatetime;
        this.duration = duration;
        this.serviceType = serviceType;
        this.status = status;
        this.comments = comments;
    }

    @Id
    @GeneratedValue
    @Column(name = "task_id", nullable = false, unique = true, length = 11)
    private int id;

    @Column(name = "start_datetime")
    private Date startDatetime;

    @Column(name = "duration")
    private int duration;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;

//    @ManyToMany(mappedBy = "tasks")
//    private List<Person> participants;

    //region getter/setter

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

//    public List<Person> getParticipants() {
//        return participants;
//    }
//
//    public void setParticipants(List<Person> participants) {
//        this.participants = participants;
//    }

    //endregion
}
