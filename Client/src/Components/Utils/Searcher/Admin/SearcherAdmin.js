import './SearcherAdmin.css'
import filter from '../../../../images/filtrar.png'
import search from '../../../../images/lupa.png'
import { useNavigate } from 'react-router-dom';

function Searcher(props){

    const navigate = useNavigate();

    const onClickHandler = async (e) => {
        navigate("/Admin/Events");
    }

    return (
        <div className='searcherA'>
            <div className='searcher-containerA'>
                <p>Buscar {props.text}...</p>
                <div className='searcher-imagesA'>
                    <img src={filter} alt="filtrar"/>
                    <img src={search} alt="buscar"/>
                </div>
            </div>
            <div className='searcher-separateA'>
            <button className='searcher-buttonA' onClick={onClickHandler}></button>
            </div>
        </div>
    );
}

export default Searcher