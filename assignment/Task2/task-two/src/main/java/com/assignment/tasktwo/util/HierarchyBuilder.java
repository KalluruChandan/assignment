package com.assignment.tasktwo.util;

import com.assignment.tasktwo.model.Hierarchy;
import com.assignment.tasktwo.model.ParentChildRelation;

import java.util.ArrayList;
import java.util.List;

public class HierarchyBuilder {

    public static List<Hierarchy> buildHierarchy(List<ParentChildRelation> allRelations){

        List<Hierarchy> hierarchy = new ArrayList<>();

        for(ParentChildRelation each : allRelations){
            if(each.getParentId() == 0){
                hierarchy.add(
                        new Hierarchy(
                                each.getName(),
                                getList(allRelations,allRelations.indexOf(each) + 1)
                        )
                );
            }
        }

        return hierarchy;
    }
    private static List<Hierarchy> getList(List<ParentChildRelation> list, int i) {
        return  list.stream().filter(each -> each.getParentId()== i).map(each->new Hierarchy(each.getName())).toList();
    }
}
