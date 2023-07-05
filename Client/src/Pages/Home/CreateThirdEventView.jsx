import React from "react";
import ThirdStepView from '../../Components/CreateEvent/ThirdStepView/ThirdStepView'

function CreateThirdEventView({onPreviousStep, handleCancelCreate}) {
  return <ThirdStepView onPreviousStep={onPreviousStep} onCancelCreate={handleCancelCreate}/>;
}

export default CreateThirdEventView;