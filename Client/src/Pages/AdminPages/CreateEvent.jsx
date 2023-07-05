import React, { useState } from "react";
import LogoHeader from "../../Components/Utils/LogoHeader/LogoHeader";
import AdminHeader from "../../Components/AdminHeader/AdminHeader";
import Separate from '../../Components/Utils/Separate/Separate';
import CardEvent from "../../Components/AdminEvent/AdminEvent";
import CreateEventView from '../../Pages/Home/CreateEventView';
import CreateSecondEventView from '../../Pages/Home/CreateSecondEventView';
import CreateThirdEventView from '../../Pages/Home/CreateThirdEventView';

function CreateEvent() {
    const [currentStep, setCurrentStep] = useState(1);

    const handleNextStep = () => {
        setCurrentStep(currentStep + 1);
    };

    const handlePreviousStep = () => {
        setCurrentStep(currentStep - 1);
    };

    const handleCancelCreate = () => {
        // Aquí puedes realizar alguna acción al cancelar la creación del evento
    };

    return (
        <div>
            <LogoHeader />
            <AdminHeader />
            <Separate />
            <CardEvent title="Crear" action="Acción de Crear" />
            {currentStep === 1 && (
                <CreateEventView onNextStep={handleNextStep} onCancelCreate={handleCancelCreate} />
            )}
            {currentStep === 2 && (
                <CreateSecondEventView onNextStep={handleNextStep} onPreviousStep={handlePreviousStep} onCancelCreate={handleCancelCreate} />
            )}
            {currentStep === 3 && (
                <CreateThirdEventView onPreviousStep={handlePreviousStep} onCancelCreate={handlePreviousStep} />
            )}
        </div>
    );
}

export default CreateEvent;
