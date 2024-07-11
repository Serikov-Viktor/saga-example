package com.serikov.saga.service.steps;

import com.serikov.saga.service.WorkflowStepStatus;
import reactor.core.publisher.Mono;

public interface WorkflowStep {

    WorkflowStepStatus getStatus();
    Mono<Boolean> process();
    Mono<Boolean> revert();
}
