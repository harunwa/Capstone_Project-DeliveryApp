import {Link, Outlet, useNavigate} from "react-router-dom";
import Logout from "./Logout";

const Navigation = () => {
    const navigate = useNavigate();
    const handleLogout = () => {
        navigate("/");
    }
    return ( 
        <>
        <nav>
            <ul>
                <li><Link to ="/profile">Profile</Link></li>
                <li><Link to ="/all-deliveries">All Deliveries</Link></li>
                <li><Link to ="/my-deliveries">My Deliveries</Link></li>
                <li><Link to ="/delivery-history">Delivery History</Link></li>
                <li><Link to ="#" onClick={handleLogout}> Logout </Link></li>
            </ul>
        </nav>
        <Outlet/>
        </>
     );
}
 
export default Navigation;