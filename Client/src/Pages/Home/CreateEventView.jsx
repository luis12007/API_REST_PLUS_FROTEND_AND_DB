import React from "react";
import FirstStepView from "../../Components/CreateEvent/FirstStepView/FirstStepView";

function CreateEventView({ onNextStep, onCancelCreate }) {
  return <FirstStepView onNextStep={onNextStep} onPreviousStep={onCancelCreate}/>;
}

export default CreateEventView;