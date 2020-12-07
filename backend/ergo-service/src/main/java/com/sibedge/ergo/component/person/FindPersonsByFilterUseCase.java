package com.sibedge.ergo.component.person;

import com.sibedge.ergo.api.PersonFilter;
import com.sibedge.ergo.shared.transport.ListData;
import com.sibedge.ergo.shared.transport.PersonData;

import org.springframework.data.domain.Pageable;

/**
 * Describes a use case when a user want to find
 * particular persons providing a set of criteria to be applied.
 */
public interface FindPersonsByFilterUseCase {
    /**
     * Finds person records which satisfy filter criteria.
     *
     * @param personFilter criteria
     * @param pageable     pagination
     * @return found list of persons
     */
    ListData<PersonData> execute(PersonFilter personFilter, Pageable pageable);
}
