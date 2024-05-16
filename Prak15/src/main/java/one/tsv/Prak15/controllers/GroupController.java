package one.tsv.Prak15.controllers;

import lombok.RequiredArgsConstructor;
import one.tsv.Prak15.models.Group;
import one.tsv.Prak15.services.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/groups")
public class GroupController {
    private GroupService service;

    @GetMapping
    @ResponseBody
    public List<Group> getList() {
        return service.getAllGroups();
    }

    @PostMapping(consumes="application/json")
    @ResponseBody
    public Group add(@RequestBody Group group) {
        service.addGroup(group);
        return group;
    }

    @DeleteMapping(path="/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        return "Count: " + service.deleteGroupById(id);
    }
}
