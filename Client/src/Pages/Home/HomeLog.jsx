import React from 'react';
import Footer from '../../Components/Utils/Footer/Footer'
import Header from '../../Components/Utils/Header/Header'
import Main from '../../Components/UserHomeView/Main/EventsContainer/EventsContainer'
import LogoHeader from '../../Components/Utils/LogoHeader/LogoHeader'
import Searcher from '../../Components/Utils/Searcher/Searcher'
import IdentifierComponent from '../../Components/Utils/IdentifierComponent/IdentifierComponent';
import SearcherAdmin from '../../Components/Utils/Searcher/Admin/SearcherAdmin';
import ServicesUser from '../../Services/UserService';
import { useEffect, useState } from 'react';

function HomeLog(){
    const [isAdmin, setIsAdmin] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const token = localStorage.getItem('token');
                const data = await ServicesUser.Owmail(token);
                const userId = data.userid;

                const response = await ServicesUser.GetAssignmentByUserId(token, userId);
                console.log(response);

                if (response.rol.includes('Admin')) { // Aquí se compara con 'Admin' en mayúsculas
                    setIsAdmin(true);
                }
            } catch (error) {
                console.log('Error:', error);
            }
        };

        fetchData();
    }, []);

    return (
        <div>
            <LogoHeader />
            <Header></Header>
            {isAdmin ? <SearcherAdmin /> : <Searcher />}
            <IdentifierComponent title="Eventos Actuales" />
            <Main></Main>
            <Footer></Footer>
        </div>
    );
}

export default HomeLog;