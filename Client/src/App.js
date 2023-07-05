import './App.css';

import { BrowserRouter, Routes, Route } from "react-router-dom";
import LoginFirstTime from './Pages/Login/LogInFirst';
import HomeNoLog from './Pages/Home/NoLog/HomeNoLog';
import SignUp from './Pages/Home/NoLog/SingUp';
import Events from './Pages/Home/NoLog/Events';
import AboutUs from './Pages/Home/NoLog/AboutUs';
import FollowUs from './Pages/Home/NoLog/FollowUs';
import HomeLog from './Pages/Home/HomeLog';
import ProfileLog from './Pages/Home/ProfileLog'
import Tickets from './Pages/Home/Tickets';
import LogAuth from './Pages/Login/LogAuth';
import ProfileTicketsView from './Pages/Home/ProfileTicketsView';
import ProfileBoardView from './Pages/Home/ProfileBoardView';
import EventTicket from './Pages/Home/EventShowTicket';
import TicketSelection from './Pages/Home/TicketSelection';
import PayTickets from './Pages/Home/PayTickets';
import Payment from './Pages/Home/Payment';
import CashView from './Pages/Home/CashView';
import CardView from './Pages/Home/CardView';
import Transfer from './Pages/Home/Transfer';
import EventsNoLog from './Pages/Home/NoLog/Events';
import AboutUsNoLog from './Pages/Home/NoLog/AboutUs';
import FollowUsNolog from './Pages/Home/NoLog/FollowUs';
import EventsLog from './Pages/Home/EventsLogAc';
import AboutUsLog from './Pages/Home/AboutUsLog.jsx';
import FollowUsLog from './Pages/Home/FollowUsLog';
import MainAdmin from './Pages/AdminPages/MainAdmin';
import UserManangement from './Pages/AdminPages/UserManange.jsx';
import QRManange from './Pages/AdminPages/QRManange';
import AdminUser from './Pages/AdminPages/AdminUser';
import MainAdminDelete from './Pages/AdminPages/MainAdminDelete';
import CreateEvent from './Pages/AdminPages/CreateEvent';
import EditEvent from './Pages/AdminPages/EditEvent';


function App() {
  return (
      <BrowserRouter>
      <Routes>    
        {/* Login */}
        <Route path="/Login" element={<LoginFirstTime />} /> 
        <Route path="/Auth" element={<LogAuth/>}/>
        <Route path="/SignUp" element={<SignUp />} /> 
        {/* No Log */}
        <Route path="/" element={<HomeNoLog />} />
        <Route path="/Events" element={<EventsNoLog />} /> 
        <Route path="/AboutUs" element={<AboutUsNoLog />} /> 
        <Route path="/FollowUs" element={<FollowUsNolog />} />
        {/* Log and Adming */}
        <Route path="/HomeLog" element={<HomeLog />} /> 
        <Route path="/EventsLog" element={<EventsLog />} /> 
        <Route path="/AboutUsLog" element={<AboutUsLog />} /> 
        <Route path="/FollowUsLog" element={<FollowUsLog />} />
        <Route path="/Profile/Tickets" element={<ProfileTicketsView/>}/>
        <Route path="/Profile/Board" element={<ProfileBoardView/>}/>

        {/* Payments */}
        <Route path="/Tickets" element={<Tickets/>}></Route>
        <Route path="/Event/Name/Buy" element={<EventTicket/>}/>
        <Route path="/Event/Select" element={<TicketSelection/>}/>
        <Route path="/Payment" element={<PayTickets/>}/>
        <Route path="/Payment/Select" element={<Payment/>}/>
        <Route path="/Payment/Select/Cash" element={<CashView/>}/>
        <Route path="/Payment/Select/Card" element={<CardView/>}/>
        <Route path="/Transfer" element={<Transfer/>}/>
        
        {/* Admin */}
        <Route path="/Admin/Events" element={<MainAdmin />} />
        <Route path="/Admin/QR" element={<QRManange />} />
        <Route path="/Admin/Users" element={<UserManangement />} />

        <Route path="/Admin/User" element={<AdminUser />} />

        {/* Event */}
        <Route path="/Admin/Events/Create" element={<CreateEvent />} />
        <Route path="/Admin/Events/Edit" element={<EditEvent />} />
        <Route path="/Admin/Events/Delete" element={<MainAdminDelete />} />
      </Routes>
    </BrowserRouter>
  );
}
export default App;