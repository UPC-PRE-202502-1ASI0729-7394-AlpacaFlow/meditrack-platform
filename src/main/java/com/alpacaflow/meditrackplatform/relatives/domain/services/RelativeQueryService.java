package com.alpacaflow.meditrackplatform.relatives.domain.services;

import com.alpacaflow.meditrackplatform.relatives.domain.model.aggregates.Relative;
import com.alpacaflow.meditrackplatform.relatives.domain.model.queries.GetRelativeByIdQuery;

import java.util.Optional;

public interface RelativeQueryService {
    /**
     * Handle the GetRelativeByIdQuery to retrieve a Relative by its ID.
     * @param query The get relative by ID query.
     * @return The Relative
     * @see GetRelativeByIdQuery
     */
    Optional<Relative> handle(GetRelativeByIdQuery query);
}
