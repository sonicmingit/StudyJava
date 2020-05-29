
public class States {

  private long stateId;
  private String domain;
  private String entityId;
  private String state;
  private String attributes;
  private long eventId;
  private java.sql.Timestamp lastChanged;
  private java.sql.Timestamp lastUpdated;
  private java.sql.Timestamp created;


  public long getStateId() {
    return stateId;
  }

  public void setStateId(long stateId) {
    this.stateId = stateId;
  }


  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }


  public String getEntityId() {
    return entityId;
  }

  public void setEntityId(String entityId) {
    this.entityId = entityId;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getAttributes() {
    return attributes;
  }

  public void setAttributes(String attributes) {
    this.attributes = attributes;
  }


  public long getEventId() {
    return eventId;
  }

  public void setEventId(long eventId) {
    this.eventId = eventId;
  }


  public java.sql.Timestamp getLastChanged() {
    return lastChanged;
  }

  public void setLastChanged(java.sql.Timestamp lastChanged) {
    this.lastChanged = lastChanged;
  }


  public java.sql.Timestamp getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(java.sql.Timestamp lastUpdated) {
    this.lastUpdated = lastUpdated;
  }


  public java.sql.Timestamp getCreated() {
    return created;
  }

  public void setCreated(java.sql.Timestamp created) {
    this.created = created;
  }

}
