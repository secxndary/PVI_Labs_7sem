package by.bstu.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WSREFCOMMENT")
public class WSRefComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "wsref_id", referencedColumnName = "id")
    private WSRef wsref;

    @Column(name = "session_id", nullable = false)
    private String sessionId;

    @Column(name = "stamp", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date stamp;

    @Column(name = "comtext", nullable = false)
    private String comtext;

    public WSRefComment() {
    }

    public WSRefComment(WSRef wsrefId, String sessionId, Date stamp, String comtext) {
        this.wsref = wsrefId;
        this.sessionId = sessionId;
        this.stamp = stamp;
        this.comtext = comtext;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WSRef getWsref() {
        return wsref;
    }

    public void setWsref(WSRef wsref) {
        this.wsref = wsref;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Date getStamp() {
        return stamp;
    }

    public void setStamp(Date stamp) {
        this.stamp = stamp;
    }

    public String getComtext() {
        return comtext;
    }

    public void setComtext(String comtext) {
        this.comtext = comtext;
    }

    @Override
    public String toString() {
        return "WSRefComment{" +
                "id=" + id +
                ", wsrefId=" + wsref +
                ", sessionId='" + sessionId + '\'' +
                ", stamp=" + stamp +
                ", comtext='" + comtext + '\'' +
                '}';
    }
}