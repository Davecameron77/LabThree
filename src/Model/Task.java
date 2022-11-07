package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "Task")
public class Task {

    public Task(Date startDatetime, int duration, String serviceType, String status, String comments) {
        this.startDatetime = startDatetime;
        this.duration = duration;
        this.serviceType = serviceType;
        this.status = status;
        this.comments = comments;

        participants = new ArrayList<>();
    }

    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Start_Datetime")
    private Date startDatetime;

    @Column(name = "Duration")
    private int duration;

    @Column(name = "Service_Type")
    private String serviceType;

    @Column(name = "Status")
    private String status;

    @Column(name = "Comments")
    private String comments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private ArrayList<Person> participants;

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

    public ArrayList<Person> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Person> participants) {
        this.participants = participants;
    }

    //endregion
}
