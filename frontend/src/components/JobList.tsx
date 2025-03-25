import React, { useEffect, useState } from 'react';
import api from '../api/axios';

interface Job {
    id: number;
    title: string;
    company: string;
}

const JobList: React.FC = () => {
    const [jobs, setJobs] = useState<Job[]>([]);

    // Fetch jobs from backend on component mount
    useEffect(() => {
        const fetchJobs = async () => {
            try {
                const response = await api.get('/jobs'); // Adjust based on your backend API endpoint
                setJobs(response.data); // Set the data from the backend to state
            } catch (error) {
                console.error("Error fetching jobs", error);
            }
        };

        fetchJobs();
    }, []); // Empty dependency array means this runs once when the component mounts

    return (
        <div>
            <h2>Job Listings</h2>
        <ul>
            {jobs.map(job => (
                    <li key={job.id}>
                        {job.title} at {job.company}
                    </li>
            ))}
        </ul>
        </div>
    );
};

export default JobList;
