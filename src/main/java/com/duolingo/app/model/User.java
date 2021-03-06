package com.duolingo.app.model;

import org.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser")
	private int idUser;
	
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "money")
	private int money;
	
	@Column(name = "xp")
	private int xp;

	@Column(name = "elo")
	private int elo;
	
	@Column(name = "avatar")
	private String avatar;

	@ManyToOne()
	@JoinColumn(name = "idOriginLang")
	private Language idOriginLang;
	
	@ManyToOne()
	@JoinColumn(name = "idRank")
	private Rank idRank;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL} )
	@JoinTable(
			name = "users_items",
			joinColumns = { @JoinColumn(name = "idUser") },
			inverseJoinColumns = { @JoinColumn(name = "idItem") }
	)
	private Set<Item> userItems = new HashSet<Item>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL} )
	@JoinTable(
			name = "users_levels",
			joinColumns = { @JoinColumn(name = "idUser") },
			inverseJoinColumns = { @JoinColumn(name = "idLevel") }
	)
	private Set<Level> userLevels = new HashSet<Level>();
	
	public User() {}

	public User(int idUser, String username, String password, String email, int money, int xp, int elo, String avatar, Rank idRank) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.email = email;
		this.money = money;
		this.xp = xp;
		this.elo = elo;
		this.avatar = avatar;
		this.idRank = idRank;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getElo() {
		return elo;
	}

	public void setElo(int elo) {
		this.elo = elo;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Language getIdOriginLang() {
		return idOriginLang;
	}

	public void setIdOriginLang(Language idOriginLang) {
		this.idOriginLang = idOriginLang;
	}

	public Rank getIdRank() {
		return idRank;
	}

	public void setIdRank(Rank idRank) {
		this.idRank = idRank;
	}

	public Set<Item> getUserItems() {
		return userItems;
	}

	public void setUserItems(Set<Item> userItems) {
		this.userItems = userItems;
	}

	public Set<Level> getUserLevels() {
		return userLevels;
	}

	public void setUserLevels(Set<Level> userLevels) {
		this.userLevels = userLevels;
	}

	public JSONObject toJSON() {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("idUser", idUser);
		jsonObject.put("money", money);
		jsonObject.put("xp", xp);
		jsonObject.put("elo", elo);
		return jsonObject;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", money=" + money + ", xp=" + xp + ", avatar=" + avatar + ", idOriginLang=" + idOriginLang
				+ ", idRank=" + idRank + "]";
	}
	
	

}
