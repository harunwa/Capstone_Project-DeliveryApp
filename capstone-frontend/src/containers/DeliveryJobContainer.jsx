import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Navigation from "../components/Navigation";
import { useEffect, useState } from "react";
import DeliveryJobList from "../components/DeliveryJobList";

const API_ROOT = "http://localhost:8080"

const DeliveryJobContainer = () => {
    const [jobs, setJobs] = useState([]);
    const [userJobs, setUserJobs] = useState([]);

    const fetchDeliveryJobs = async () => {
        const response = await fetch(`${API_ROOT}/orders`);
        const jsonData = await response.json();
        setJobs(jsonData);
        console.log(jsonData);
    }

    const fetchUserJobs = async () => {
        const response = await fetch(`${API_ROOT}/users/1/orders`);
//
        // change 1 to :id once user and useparams are setup
//
        const jsonData = await response.json();
        setUserJobs(jsonData);
        console.log(jsonData);
    }

    useEffect(() => {
        fetchDeliveryJobs();
        fetchUserJobs();
    }, [])

    const deliveryRoute = createBrowserRouter([
        {
            path: "/", 
            element: (<> <Navigation /></>), 
            children: [
                {
                    path: "/profile",
                    element: (<> <h1>Profile</h1></>)
                },
                {
                    path: "/profile/:id/edit",
                    element: (<> <h1>Edit Profile</h1> </>)
                },
                {
                    path: "/all-deliveries",
                    element: (<> 
                                <DeliveryJobList jobs={jobs}/>
                            </>)
                },
                {
                    path: "/my-deliveries",
                    element: (<> <h1>My Deliveries</h1></>)
                },
                {
                    path: "/delivery-history",
                    element: (<> <h1> Deliverie History</h1></>)
                },
                {
                    path: "/order-status",
                    element: (<> <h1> Order Status </h1></>)
                }
            ]
        }
        
    ])

    return ( 
        <>
            <RouterProvider router={deliveryRoute} />
        </> 
    );
}
 
export default DeliveryJobContainer;