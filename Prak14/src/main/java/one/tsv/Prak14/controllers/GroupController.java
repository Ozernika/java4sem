package one.tsv.Prak14.controllers;

import one.tsv.Prak14.models.Group;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/groups")
public class GroupController {
    private ArrayList<Group> groups = new ArrayList<>();

    @GetMapping
    @ResponseBody
    public List<Group> getList() {
        return groups.stream().toList();
    }

    @PostMapping(consumes="application/json")
    @ResponseBody
    public Group add(@RequestBody Group group) {
        int lenBefore = groups.size();
        groups.add(group);
        if (groups.size() != lenBefore)
            return group;
        else
            return null;
    }

    @DeleteMapping(consumes="application/json")
    @ResponseBody
    public Group delete(@RequestBody Group group) {
        int lenBefore = groups.size();
        groups = new ArrayList<>(
                groups.stream()
                        .filter((authorListItem -> !authorListItem.equals(group)))
                        .toList()
        );
        if (groups.size() != lenBefore)
            return group;
        else
            return null;
    }
}
