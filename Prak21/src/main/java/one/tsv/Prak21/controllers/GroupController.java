package one.tsv.Prak21.controllers;

import lombok.RequiredArgsConstructor;
import one.tsv.Prak21.dto.GroupDto;
import one.tsv.Prak21.models.Group;
import one.tsv.Prak21.services.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/groups")
public class GroupController {
    private final GroupService service;

    @GetMapping
    @ResponseBody
    public List<GroupDto> getList() {
        return service.getAllGroups().stream().map(Group::toDto).toList();
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
