package game.model;

import java.util.Objects;

public class Players {
	private int playerID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    
	public Players(int playerID, String firstName, String lastName, String emailAddress) {
		this.playerID = playerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}

	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Players players = (Players) o;
      return
        playerID == players.playerID &&
        Objects.equals(firstName, players.firstName) &&
        Objects.equals(lastName, players.lastName) &&
        Objects.equals(emailAddress, players.emailAddress);
    }

    @Override
    public int hashCode() {
      throw new UnsupportedOperationException("hashing not supported");
    }

	@Override
	public String toString() {
		return "Players [playerID=" + playerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailAddress=" + emailAddress + "]";
	}
    
}