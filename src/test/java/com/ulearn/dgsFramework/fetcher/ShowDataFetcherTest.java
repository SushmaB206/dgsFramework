package com.ulearn.dgsFramework.fetcher;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import com.ulearn.dgsFramework.datafetcher.ShowDataFetcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*import com.ulearn.dgsFramework.generated.client.ShowsGraphQLQueryl;*/

import static org.junit.Assert.assertEquals;

import java.util.List;

@SpringBootTest(classes = {DgsAutoConfiguration.class, ShowDataFetcher.class})
public class ShowDataFetcherTest {

    @Autowired
    DgsQueryExecutor queryExecutor;

    @Test
    void shows(){

       /* GraphQLQueryRequest qlQueryRequest =
                new GraphQLQueryRequest(ShowsGraphQLQuery.newRequest().titleFilter("B").build(),
                       new ShowsProjectionRoot().title());
        String query = qlQueryRequest.serialize();*/

        String query = "{ \n" +
                "showsByFilter(titleFilter:\"B\"){\n" +
                "    title\n" +
                "    releaseYear\n" +
                "  }\n" +
                "}";
        List<String> titles = queryExecutor.executeAndExtractJsonPath(query, "data.showsByFilter[*].title");
       // assertEquals(titles, "[\"BBBB\"]");
    }
}
