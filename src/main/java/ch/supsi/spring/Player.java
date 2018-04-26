package ch.supsi.spring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Player {
	/*,Name,Age,Photo,Nationality,Flag,Overall,Potential,Club,Club Logo,Value,Wage,Special,Acceleration,Aggression,Agility,
	Balance,Ball control,Composure,Crossing,Curve,Dribbling,Finishing,Free kick accuracy,GK diving,GK handling,GK kicking,
	GK positioning,GK reflexes,Heading accuracy,Interceptions,Jumping,Long passing,Long shots,Marking,Penalties,Positioning,
	Reactions,Short passing,Shot power,Sliding tackle,Sprint speed,Stamina,Standing tackle,Strength,Vision,Volleys,
	CAM,CB,CDM,CF,CM,ID,LAM,LB,LCB,LCM,LDM,LF,LM,LS,LW,LWB,Preferred Positions,RAM,RB,RCB,RCM,RDM,RF,RM,RS,RW,RWB,ST
	 */

	private long myId;
	private String name;
	private int age;
	private String nationality;
	private double overall;
	private double potential;
	private String club;
	private String value;
	private String wage; //stipendio
	private double special;
    private double acceleration;
    private double aggression;
    private double agility;
    private double balance;
    private double ballControl;
    private double composure;
    private double crossing;
    private double curve;
    private double dribbling;
    private double finishing;
    private double freeKickAccuracy;
    private double GKDiving;
    private double GKHandling;
    private double GKKicking;
    private double GKPositioning;
    private double GKReflexes;
    private double headingAccuracy;
    private double interceptions;
    private double jumping;
    private double longPassing;
    private double longShots;
    private double marking;
    private double penalties;
    private double positioning;
    private double reactions;
    private double shortPassing;
    private double shotPower;
    private double slidingTackle;
    private double sprintSpeed;
    private double stamina;
    private double standingTackle;
    private double strength;
    private double vision;
    private double volleys;
	private double CAM,CB,CDM,CF,CM,ID,LAM,LB,LCB,LCM,LDM,LF,LM,LS,LW,LWB;
	private String preferredPositions;
	private double RAM, RB, RCB, RCM, RDM, RF, RM, RS, RW, RWB, ST;
    private double totalPoints;
    private int digitalValue = -1;
    private int digitalWage = -1;
    private double priceOnAbility = -1;

    public Player() {
    }

	public Player(long myId, String name) {
		this.myId = myId;
		this.name = name;
	}

    public double compareToAttibute(String playerAttribute, Player player) {
        double totalPoints = 0, myPoints = 0;

        try {
            Method receivedPlayerMethod = this.getClass().getMethod("get" + playerAttribute);
            totalPoints = (double)receivedPlayerMethod.invoke(player);

            Method mydPlayerMethod = this.getClass().getMethod("get" + playerAttribute);
            myPoints = (double)mydPlayerMethod.invoke(this);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return totalPoints - myPoints;
    }

    public double compareToWage(Player player) {
        int totalPoints = player.getDigitalWage();

        //ascending order
        //return this.totalPoints - totalPoints;

        //descending order
        return totalPoints - this.digitalWage;
    }

    public double compareToPrice(Player player) {
        int totalPoints = player.getDigitalValue();

        //ascending order
        //return this.totalPoints - totalPoints;

        //descending order
        return totalPoints - this.digitalValue;
    }

    public double compareToPriceOnAbility(Player player) {
        double totalPoints = player.getPriceOnAbility();

        //ascending order
        return this.totalPoints - totalPoints;

        //descending order
        //return totalPoints - this.priceOnAbility;

    }

    public double compareToTotalPoints(Player player) {
        double totalPoints = player.getTotalPoints();

        //ascending order
        //return this.totalPoints - totalPoints;

        //descending order
        return totalPoints - this.totalPoints;

    }

    public double getPriceOnAbility() {
        return priceOnAbility;
    }

    public void setPriceOnAbility(double priceOnAbility) {
        this.priceOnAbility = priceOnAbility;
    }

    public int getDigitalWage() {
        return digitalWage;
    }

    public void setDigitalWage(int digitalWage) {
        this.digitalWage = digitalWage;
    }

    public int getDigitalValue() {
        return digitalValue;
    }

    public void setDigitalValue(int digitalValue) {
        this.digitalValue = digitalValue;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public long getMyId() {
        return myId;
    }

    public void setMyId(long myId) {
        this.myId = myId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getOverall() {
        return overall;
    }

    public void setOverall(double overall) {
        this.overall = overall;
    }

    public double getPotential() {
        return potential;
    }

    public void setPotential(double potential) {
        this.potential = potential;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    public double getSpecial() {
        return special;
    }

    public void setSpecial(double special) {
        this.special = special;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getAggression() {
        return aggression;
    }

    public void setAggression(double aggression) {
        this.aggression = aggression;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBallControl() {
        return ballControl;
    }

    public void setBallControl(double ballControl) {
        this.ballControl = ballControl;
    }

    public double getComposure() {
        return composure;
    }

    public void setComposure(double composure) {
        this.composure = composure;
    }

    public double getCrossing() {
        return crossing;
    }

    public void setCrossing(double crossing) {
        this.crossing = crossing;
    }

    public double getCurve() {
        return curve;
    }

    public void setCurve(double curve) {
        this.curve = curve;
    }

    public double getDribbling() {
        return dribbling;
    }

    public void setDribbling(double dribbling) {
        this.dribbling = dribbling;
    }

    public double getFinishing() {
        return finishing;
    }

    public void setFinishing(double finishing) {
        this.finishing = finishing;
    }

    public double getFreeKickAccuracy() {
        return freeKickAccuracy;
    }

    public void setFreeKickAccuracy(double freeKickAccuracy) {
        this.freeKickAccuracy = freeKickAccuracy;
    }

    public double getGKDiving() {
        return GKDiving;
    }

    public void setGKDiving(double GKDiving) {
        this.GKDiving = GKDiving;
    }

    public double getGKHandling() {
        return GKHandling;
    }

    public void setGKHandling(double GKHandling) {
        this.GKHandling = GKHandling;
    }

    public double getGKKicking() {
        return GKKicking;
    }

    public void setGKKicking(double GKKicking) {
        this.GKKicking = GKKicking;
    }

    public double getGKPositioning() {
        return GKPositioning;
    }

    public void setGKPositioning(double GKPositioning) {
        this.GKPositioning = GKPositioning;
    }

    public double getGKReflexes() {
        return GKReflexes;
    }

    public void setGKReflexes(double GKReflexes) {
        this.GKReflexes = GKReflexes;
    }

    public double getHeadingAccuracy() {
        return headingAccuracy;
    }

    public void setHeadingAccuracy(double headingAccuracy) {
        this.headingAccuracy = headingAccuracy;
    }

    public double getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(double interceptions) {
        this.interceptions = interceptions;
    }

    public double getJumping() {
        return jumping;
    }

    public void setJumping(double jumping) {
        this.jumping = jumping;
    }

    public double getLongPassing() {
        return longPassing;
    }

    public void setLongPassing(double longPassing) {
        this.longPassing = longPassing;
    }

    public double getLongShots() {
        return longShots;
    }

    public void setLongShots(double longShots) {
        this.longShots = longShots;
    }

    public double getMarking() {
        return marking;
    }

    public void setMarking(double marking) {
        this.marking = marking;
    }

    public double getPenalties() {
        return penalties;
    }

    public void setPenalties(double penalties) {
        this.penalties = penalties;
    }

    public double getPositioning() {
        return positioning;
    }

    public void setPositioning(double positioning) {
        this.positioning = positioning;
    }

    public double getReactions() {
        return reactions;
    }

    public void setReactions(double reactions) {
        this.reactions = reactions;
    }

    public double getShortPassing() {
        return shortPassing;
    }

    public void setShortPassing(double shortPassing) {
        this.shortPassing = shortPassing;
    }

    public double getShotPower() {
        return shotPower;
    }

    public void setShotPower(double shotPower) {
        this.shotPower = shotPower;
    }

    public double getSlidingTackle() {
        return slidingTackle;
    }

    public void setSlidingTackle(double slidingTackle) {
        this.slidingTackle = slidingTackle;
    }

    public double getSprintSpeed() {
        return sprintSpeed;
    }

    public void setSprintSpeed(double sprintSpeed) {
        this.sprintSpeed = sprintSpeed;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public double getStandingTackle() {
        return standingTackle;
    }

    public void setStandingTackle(double standingTackle) {
        this.standingTackle = standingTackle;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getVision() {
        return vision;
    }

    public void setVision(double vision) {
        this.vision = vision;
    }

    public double getVolleys() {
        return volleys;
    }

    public void setVolleys(double volleys) {
        this.volleys = volleys;
    }

    public double getCAM() {
        return CAM;
    }

    public void setCAM(double CAM) {
        this.CAM = CAM;
    }

    public double getCB() {
        return CB;
    }

    public void setCB(double CB) {
        this.CB = CB;
    }

    public double getCDM() {
        return CDM;
    }

    public void setCDM(double CDM) {
        this.CDM = CDM;
    }

    public double getCF() {
        return CF;
    }

    public void setCF(double CF) {
        this.CF = CF;
    }

    public double getCM() {
        return CM;
    }

    public void setCM(double CM) {
        this.CM = CM;
    }

    public double getID() {
        return ID;
    }

    public void setID(double ID) {
        this.ID = ID;
    }

    public double getLAM() {
        return LAM;
    }

    public void setLAM(double LAM) {
        this.LAM = LAM;
    }

    public double getLB() {
        return LB;
    }

    public void setLB(double LB) {
        this.LB = LB;
    }

    public double getLCB() {
        return LCB;
    }

    public void setLCB(double LCB) {
        this.LCB = LCB;
    }

    public double getLCM() {
        return LCM;
    }

    public void setLCM(double LCM) {
        this.LCM = LCM;
    }

    public double getLDM() {
        return LDM;
    }

    public void setLDM(double LDM) {
        this.LDM = LDM;
    }

    public double getLF() {
        return LF;
    }

    public void setLF(double LF) {
        this.LF = LF;
    }

    public double getLM() {
        return LM;
    }

    public void setLM(double LM) {
        this.LM = LM;
    }

    public double getLS() {
        return LS;
    }

    public void setLS(double LS) {
        this.LS = LS;
    }

    public double getLW() {
        return LW;
    }

    public void setLW(double LW) {
        this.LW = LW;
    }

    public double getLWB() {
        return LWB;
    }

    public void setLWB(double LWB) {
        this.LWB = LWB;
    }

    public String getPreferredPositions() {
        return preferredPositions;
    }

    public void setPreferredPositions(String preferredPositions) {
        this.preferredPositions = preferredPositions;
    }

    public double getRAM() {
        return RAM;
    }

    public void setRAM(double RAM) {
        this.RAM = RAM;
    }

    public double getRB() {
        return RB;
    }

    public void setRB(double RB) {
        this.RB = RB;
    }

    public double getRCB() {
        return RCB;
    }

    public void setRCB(double RCB) {
        this.RCB = RCB;
    }

    public double getRCM() {
        return RCM;
    }

    public void setRCM(double RCM) {
        this.RCM = RCM;
    }

    public double getRDM() {
        return RDM;
    }

    public void setRDM(double RDM) {
        this.RDM = RDM;
    }

    public double getRF() {
        return RF;
    }

    public void setRF(double RF) {
        this.RF = RF;
    }

    public double getRM() {
        return RM;
    }

    public void setRM(double RM) {
        this.RM = RM;
    }

    public double getRS() {
        return RS;
    }

    public void setRS(double RS) {
        this.RS = RS;
    }

    public double getRW() {
        return RW;
    }

    public void setRW(double RW) {
        this.RW = RW;
    }

    public double getRWB() {
        return RWB;
    }

    public void setRWB(double RWB) {
        this.RWB = RWB;
    }

    public double getST() {
        return ST;
    }

    public void setST(double ST) {
        this.ST = ST;
    }
}