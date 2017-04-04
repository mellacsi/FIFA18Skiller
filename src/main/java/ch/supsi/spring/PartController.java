package ch.supsi.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartController {
	private List<Part> parts = new ArrayList<Part>();
	
	@RequestMapping(value="/parts", method = RequestMethod.GET)
	public List<Part> getPartList() {
		return parts;
	}

	@RequestMapping(value="/parts/{part_id}", method = RequestMethod.GET)
	public Part getPart(
			@PathVariable Long part_id
	) {
		return parts.stream().filter(p -> p.getId() == part_id).findFirst().get();
	}

	@RequestMapping(value="/parts", method = RequestMethod.POST)
	public Part createPart(
			@RequestParam String name,
			@RequestParam String description
	) {
		Part part = new Part(this.parts.size()+1, name, description);
		this.parts.add(part);
		return part;
	}

}