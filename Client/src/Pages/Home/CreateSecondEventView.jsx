import React from "react";
import SecondStepView from '../../Components/CreateEvent/SecondStepView/SecondStepView'

function CreateSecondEventView({ onNextStep, onPreviousStep, onCancelCreate }) {
  return <SecondStepView onNextStep={onNextStep} onPreviousStep={onPreviousStep} onCancelCreate={onCancelCreate}/>;
}

export default CreateSecondEventView;