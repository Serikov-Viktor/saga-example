package com.serikov.saga.service;

import com.serikov.saga.service.steps.WorkflowStep;

import java.util.List;

public interface Workflow {

    List<WorkflowStep> getSteps();
}
