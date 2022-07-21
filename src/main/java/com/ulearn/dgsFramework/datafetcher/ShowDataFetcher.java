package com.ulearn.dgsFramework.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.ulearn.dgsFramework.model.Show;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ShowDataFetcher {

    private Show show;
    private List<Show> showList = List.of(
            Show.builder().title("AAAA").releaseYear(2017).build(),
            Show.builder().title("BBBB").releaseYear(2018).build(),
            Show.builder().title("CCCC").releaseYear(2019).build(),
            Show.builder().title("DDDD").releaseYear(2020).build()
            );

    @DgsData(parentType = "Query", field = "shows")
    public List<Show> shows(){
        return showList;
    }

    @DgsQuery
    public List<Show> showsByFilter(@InputArgument String titleFilter){
        if(titleFilter != null){
            return showList.stream().filter(name->name.getTitle().startsWith(titleFilter)).collect(Collectors.toList());
        }
        return showList;
    }
}
