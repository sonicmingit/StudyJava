
public class Events {

  private long eventId;
  private String eventType;
  private String eventData;
  private String origin;
  private java.sql.Timestamp timeFired;
  private java.sql.Timestamp created;


  public long getEventId() {
    return eventId;
  }

  public void setEventId(long eventId) {
    this.eventId = eventId;
  }


  public String getEventType() {
    return eventType;
  }

  public void setEventType(String eventType) {
    this.eventType = eventType;
  }


  public String getEventData() {
    return eventData;
  }

  public void setEventData(String eventData) {
    this.eventData = eventData;
  }


  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }


  public java.sql.Timestamp getTimeFired() {
    return timeFired;
  }

  public void setTimeFired(java.sql.Timestamp timeFired) {
    this.timeFired = timeFired;
  }


  public java.sql.Timestamp getCreated() {
    return created;
  }

  public void setCreated(java.sql.Timestamp created) {
    this.created = created;
  }

}
