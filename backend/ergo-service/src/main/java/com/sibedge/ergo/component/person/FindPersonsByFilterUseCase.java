package com.sibedge.ergo.component.person;

import com.sibedge.ergo.api.PersonFilter;
import com.sibedge.ergo.component.person.domain.Person;
import com.sibedge.ergo.shared.transport.ListData;
import com.sibedge.ergo.shared.transport.PersonData;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 */
public interface FindPersonsByFilterUseCase {

    /**
     *
     * @param personFilter
     * @param pageable
     * @return
     */
    ListData<PersonData> execute(PersonFilter personFilter, Pageable pageable);

}
