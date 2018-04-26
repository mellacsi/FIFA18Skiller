package ch.supsi.spring;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    private List<Player> players = new ArrayList<>();

    @PostConstruct
    public void init() throws Exception{
        //load file
        Reader in = new FileReader("./src/main/resources/static/dataset/CompleteDataset.csv");
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);

        int counter = 0;
        ArrayList<ArrayList<String>> modifiedRecords = new ArrayList<>();

        for (CSVRecord record : records) {
            ArrayList<String> thisRecord = new ArrayList<>();
            for (String field : record) {
                thisRecord.add(field);
            }
            modifiedRecords.add(thisRecord);
        }


        for (ArrayList<String> record : modifiedRecords) {
            if (counter == 0) {
                System.out.println("----------------------ATTRIBUTES----------------------");
                for (int i = 0; i < record.size(); i++) {
                    System.out.print(i + "-" + record.get(i) + "    ");
                }
                System.out.println();
            } else {
                Player p = new Player();
                for (int i = 0; i < record.size(); i++) {
                    if(i >= 6 && i != 8 && i != 10 && i != 11 && i != 63) {
                        String field = record.get(i);
                        if(field.contains("+")){
                            String[] numbers = field.split("\\+");
                            double a = Double.parseDouble(numbers[0]);
                            double b = Double.parseDouble(numbers[1]);
                            double c = a+b;
                            record.set(i, c+"");
                        }else if(field.contains("-")){
                            String[] numbers = field.split("\\-");
                            double a = Double.parseDouble(numbers[0]);
                            double b = Double.parseDouble(numbers[1]);
                            double c = a-b;
                            record.set(i, c+"");
                        }
                    }
                }

                p.setMyId(Integer.parseInt(record.get(0)));
                p.setName(record.get(1));
                p.setAge(Integer.parseInt(record.get(2)));
                p.setNationality(record.get(4));
                p.setOverall(Double.parseDouble(record.get(6)));
                p.setPotential(Double.parseDouble(record.get(7)));
                p.setClub(record.get(8));
                p.setValue(record.get(10));
                p.setWage(record.get(11));
                p.setSpecial(Double.parseDouble(record.get(12)));
                p.setAcceleration(Double.parseDouble(record.get(13)));
                p.setAggression(Double.parseDouble(record.get(14)));
                p.setAgility(Double.parseDouble(record.get(15)));
                p.setBalance(Double.parseDouble(record.get(16)));
                p.setBallControl(Double.parseDouble(record.get(17)));
                p.setComposure(Double.parseDouble(record.get(18)));
                p.setCrossing(Double.parseDouble(record.get(19)));
                p.setCurve(Double.parseDouble(record.get(20)));
                p.setDribbling(Double.parseDouble(record.get(21)));
                p.setFinishing(Double.parseDouble(record.get(22)));
                p.setFreeKickAccuracy(Double.parseDouble(record.get(23)));
                p.setGKDiving(Double.parseDouble(record.get(24)));
                p.setGKHandling(Double.parseDouble(record.get(25)));
                p.setGKKicking(Double.parseDouble(record.get(26)));
                p.setGKPositioning(Double.parseDouble(record.get(27)));
                p.setGKReflexes(Double.parseDouble(record.get(28)));
                p.setHeadingAccuracy(Double.parseDouble(record.get(29)));
                p.setInterceptions(Double.parseDouble(record.get(30)));
                p.setJumping(Double.parseDouble(record.get(31)));
                p.setLongPassing(Double.parseDouble(record.get(32)));
                p.setLongShots(Double.parseDouble(record.get(33)));
                p.setMarking(Double.parseDouble(record.get(34)));
                p.setPenalties(Double.parseDouble(record.get(35)));
                p.setPositioning(Double.parseDouble(record.get(36)));
                p.setReactions(Double.parseDouble(record.get(37)));
                p.setShortPassing(Double.parseDouble(record.get(38)));
                p.setShotPower(Double.parseDouble(record.get(39)));
                p.setSlidingTackle(Double.parseDouble(record.get(40)));
                p.setSprintSpeed(Double.parseDouble(record.get(41)));
                p.setStamina(Double.parseDouble(record.get(42)));
                p.setStandingTackle(Double.parseDouble(record.get(43)));
                p.setStrength(Double.parseDouble(record.get(44)));
                p.setVision(Double.parseDouble(record.get(45)));
                p.setVolleys(Double.parseDouble(record.get(46)));

                if(!record.get(47).equals(""))
                    p.setCAM(Double.parseDouble(record.get(47)));

                if(!record.get(48).equals(""))
                    p.setCB(Double.parseDouble(record.get(48)));

                if(!record.get(49).equals(""))
                    p.setCDM(Double.parseDouble(record.get(49)));

                if(!record.get(50).equals(""))
                    p.setCF(Double.parseDouble(record.get(50)));

                if(!record.get(51).equals(""))
                    p.setCM(Double.parseDouble(record.get(51)));
                //sempre ok
                p.setID(Double.parseDouble(record.get(52)));

                if(!record.get(53).equals(""))
                    p.setLAM(Double.parseDouble(record.get(53)));

                if(!record.get(54).equals(""))
                    p.setLB(Double.parseDouble(record.get(54)));

                if(!record.get(55).equals(""))
                    p.setLCB(Double.parseDouble(record.get(55)));

                if(!record.get(56).equals(""))
                    p.setLCM(Double.parseDouble(record.get(56)));

                if(!record.get(57).equals(""))
                    p.setLDM(Double.parseDouble(record.get(57)));

                if(!record.get(58).equals(""))
                    p.setLF(Double.parseDouble(record.get(58)));

                if(!record.get(59).equals(""))
                    p.setLM(Double.parseDouble(record.get(59)));

                if(!record.get(60).equals(""))
                    p.setLS(Double.parseDouble(record.get(60)));

                if(!record.get(61).equals(""))
                    p.setLW(Double.parseDouble(record.get(61)));

                if(!record.get(62).equals(""))
                    p.setLWB(Double.parseDouble(record.get(62)));
                //sempre ok
                p.setPreferredPositions(record.get(63));

                if(!record.get(64).equals(""))
                    p.setRAM(Double.parseDouble(record.get(64)));

                if(!record.get(65).equals(""))
                    p.setRB(Double.parseDouble(record.get(65)));

                if(!record.get(66).equals(""))
                    p.setRCB(Double.parseDouble(record.get(66)));

                if(!record.get(67).equals(""))
                    p.setRCM(Double.parseDouble(record.get(67)));

                if(!record.get(68).equals(""))
                    p.setRDM(Double.parseDouble(record.get(68)));

                if(!record.get(69).equals(""))
                    p.setRF(Double.parseDouble(record.get(69)));

                if(!record.get(70).equals(""))
                    p.setRM(Double.parseDouble(record.get(70)));

                if(!record.get(71).equals(""))
                    p.setRS(Double.parseDouble(record.get(71)));

                if(!record.get(72).equals(""))
                    p.setRW(Double.parseDouble(record.get(72)));

                if(!record.get(73).equals(""))
                    p.setRWB(Double.parseDouble(record.get(73)));

                if(!record.get(74).equals(""))
                    p.setST(Double.parseDouble(record.get(74)));

                double totalPoints = 0;
                for (int i = 0; i < record.size(); i++) {
                    if (i > 6 && i != 8 && i != 9 && i != 10 && i != 11 && i != 52  && i != 63) {
                        if(!record.get(i).equals(""))
                            totalPoints += Double.parseDouble(record.get(i));
                    }
                }
                p.setTotalPoints(totalPoints);
                players.add(p);
            }
            counter++;
        }

        players.sort((o1, o2) -> (int)o1.compareToTotalPoints(o2));
        System.out.println("Number of player: " + counter);
    }

    public List<Player> getPlayers(){
        return players;
    }

    public List<Player> getFromRole(String player_role) {
        List<Player> findedPlayers = new ArrayList<>();
        String[] roles = player_role.split(" ");
        String findedRoles;
        for (Player player: players) {
            findedRoles = player.getPreferredPositions();
            for (String role: roles) {
                if(findedRoles.toLowerCase().contains(role.toLowerCase())) {
                    findedPlayers.add(player);
                    continue;
                }
            }
        }
        return findedPlayers;
    }

    public List<Player> getFromAttribute(String player_attribute) {
        List<Player> findedPlayers = new ArrayList<>(players);
        findedPlayers.sort((o1, o2) -> (int)o1.compareToAttibute(player_attribute, o2));
        return findedPlayers;
    }

    private int setDigitalPriceOrWage(Player player, boolean flag) {
        if(player.getPriceOnAbility() != -1) {
            if (flag)
                return player.getDigitalValue();
            else
                return player.getDigitalWage();
        }
        int price;

        String onlyPrice;
        boolean minusZeroWage = false;
        boolean minusZeroPrice = false;
        if(player.getValue().contains(".5"))
            minusZeroPrice = true;
        if(player.getWage().contains(".5"))
            minusZeroWage = true;

        if(flag)
            onlyPrice = player.getValue().replace(".", "");
        else
            onlyPrice = player.getWage().replace(".", "");

        onlyPrice = onlyPrice.replace("€", "");
        if(onlyPrice.contains("K")){
            String[] currentPrice = onlyPrice.split("K");
            String newPrice = currentPrice[0];
            if((minusZeroWage && !flag) || (minusZeroPrice && flag))
                newPrice = newPrice + "00";
            else
                newPrice = newPrice + "000";
            price = Integer.parseInt(newPrice);
        }else if(onlyPrice.contains("M")){
            String[] currentPrice = onlyPrice.split("M");
            String newPrice = currentPrice[0];

            if((minusZeroWage && !flag) || (minusZeroPrice && flag))
                newPrice = newPrice + "00000";
            else
                newPrice = newPrice + "000000";
            price = Integer.parseInt(newPrice);
        }else{
            price = Integer.parseInt(onlyPrice);
        }

        if(flag)
            player.setDigitalValue(price);
        else
            player.setDigitalWage(price);

        return price;
    }

    public List<Player> getFromPrice(int player_price) {
        List<Player> findedPlayers = new ArrayList<>();
        int price;
        for (Player player: players) {
            price = setDigitalPriceOrWage(player, true);

            if(price <= player_price)
                findedPlayers.add(player);
        }
        findedPlayers.sort((o1, o2) -> (int)o1.compareToPrice(o2));
        return findedPlayers;
    }

    public List<Player> getFromWage(int player_wage) {
        List<Player> findedPlayers = new ArrayList<>();
        int price;
        for (Player player: players) {
            price = setDigitalPriceOrWage(player, false);

            if(price <= player_wage)
                findedPlayers.add(player);
        }
        findedPlayers.sort((o1, o2) -> (int)o1.compareToWage(o2));
        return findedPlayers;
    }

    public List<Player> getPriceOnAbility() {
        for (Player player: players) {
            if(player.getPriceOnAbility() != -1)
                continue;

            int price = setDigitalPriceOrWage(player, true);
            double totAbility = player.getTotalPoints();
            player.setPriceOnAbility(((double) price) / totAbility);

        }

        List<Player> findedPlayers = new ArrayList<>();
        for (Player player : players) {
            if(player.getDigitalValue() != 0)
                findedPlayers.add(player);
        }
        findedPlayers.sort((o1, o2) -> (int)o1.compareToPriceOnAbility(o2));
        return findedPlayers;
    }
}
