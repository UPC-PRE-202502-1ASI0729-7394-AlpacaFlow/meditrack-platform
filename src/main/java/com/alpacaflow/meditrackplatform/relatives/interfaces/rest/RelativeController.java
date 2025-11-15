package com.alpacaflow.meditrackplatform.relatives.interfaces.rest;

import com.alpacaflow.meditrackplatform.relatives.domain.model.queries.GetRelativeByIdQuery;
import com.alpacaflow.meditrackplatform.relatives.domain.services.RelativeQueryService;
import com.alpacaflow.meditrackplatform.relatives.interfaces.rest.resources.RelativeResource;
import com.alpacaflow.meditrackplatform.relatives.interfaces.rest.transform.RelativeResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/relatives", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Relatives", description = "Endpoints for managing relatives")
public class RelativeController {

    private final RelativeQueryService relativeQueryService;

    public RelativeController(RelativeQueryService relativeQueryService) {
        this.relativeQueryService = relativeQueryService;
    }

    @GetMapping("/{relativeId}")
    @Operation(summary = "Get relative by ID", description = "Retrieve a specific relative by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Relative found"),
            @ApiResponse(responseCode = "404", description = "Relative not found")
    })
    public ResponseEntity<RelativeResource> getRelative(@PathVariable Long relativeId) {
        var getRelativeByIdQuery = new GetRelativeByIdQuery(relativeId);
        var relative = relativeQueryService.handle(getRelativeByIdQuery);
        if(relative.isEmpty()) return ResponseEntity.notFound().build();
        var relativeResource = RelativeResourceFromEntityAssembler.toResourceFromEntity(relative.get());
        return ResponseEntity.ok(relativeResource);
    }
}
