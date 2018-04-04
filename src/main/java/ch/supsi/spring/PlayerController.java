package ch.supsi.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@RequestMapping(value="/players", method = RequestMethod.GET)
	public List<Player> getPartList() {
		return playerService.getPlayers();
	}


	@RequestMapping(value="/player/id/{player_id}", method = RequestMethod.GET)
    public Player getFromId(@PathVariable Long player_id) {
        return playerService.getPlayers().stream().filter(p -> p.getMyId() == player_id).findFirst().get();
    }

    @RequestMapping(value="/players/name/{player_name}", method = RequestMethod.GET)
    public List<Player> getFromName(@PathVariable String player_name) {
        return playerService.getPlayers().stream().filter(p -> p.getName().toLowerCase().contains(player_name.toLowerCase())).collect(Collectors.toList());
    }

    @RequestMapping(value="/players/nationality/{player_nation}", method = RequestMethod.GET)
    public List<Player> getFromNation(@PathVariable String player_nation) {
        return playerService.getPlayers().stream().filter(p -> p.getNationality().toLowerCase().contains(player_nation.toLowerCase())).collect(Collectors.toList());
    }

    @RequestMapping(value="/players/role/{player_role}", method = RequestMethod.GET)
    public List<Player> getFromRole(@PathVariable String player_role) {
        return playerService.getFromRole(player_role);
    }

    @RequestMapping(value="/players/attribute/{player_attribute}", method = RequestMethod.GET)
    public List<Player> getFromAttribute(@PathVariable String player_attribute) {
        return playerService.getFromAttribute(player_attribute);
    }

    @RequestMapping(value="/players/price/{player_price}", method = RequestMethod.GET)
    public List<Player> getFromPrice(@PathVariable int player_price) {
        return playerService.getFromPrice(player_price);
    }

    @RequestMapping(value="/players/wage/{player_wage}", method = RequestMethod.GET)
    public List<Player> getFromWage(@PathVariable int player_wage) {
        return playerService.getFromWage(player_wage);
    }

    @RequestMapping(value="/players/priceonability", method = RequestMethod.GET)
    public List<Player> getPriceOnAbility() {
        return playerService.getPriceOnAbility();
    }
}