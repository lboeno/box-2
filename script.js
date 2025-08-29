document.addEventListener('DOMContentLoaded', () => {
    // Initialize the map
    const map = L.map('map').setView([-14.2350, -51.9253], 4); // Centered on Brazil

    // Add OpenStreetMap tiles
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);

    // Function to fetch bus data
    async function fetchBusData() {
        try {
            const response = await fetch('data/bus-data.json');
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const data = await response.json();
            return data.buses;
        } catch (error) {
            console.error('Error fetching bus data:', error);
            return [];
        }
    }

    // Function to display buses on the map
    function displayBuses(buses) {
        buses.forEach(bus => {
            const marker = L.marker([bus.location.lat, bus.location.lng]).addTo(map);
            marker.bindPopup(`
                <b>Route: ${bus.route}</b><br>
                Status: ${bus.status}<br>
                Next Stop: ${bus.next_stop}
            `);
        });
    }

    // Function to populate the route list
    function populateRouteList(buses) {
        const routeList = document.getElementById('route-list-items');
        const routes = [...new Set(buses.map(bus => bus.route))]; // Get unique routes

        routes.forEach(route => {
            const li = document.createElement('li');
            li.textContent = `Route ${route}`;
            li.dataset.route = route;
            routeList.appendChild(li);
        });
    }

    // Main function to initialize the application
    async function main() {
        const buses = await fetchBusData();
        if (buses.length > 0) {
            displayBuses(buses);
            populateRouteList(buses);
        }

        // Force map size invalidation after a short delay
        // This can help if the map container size is not immediately available
        setTimeout(() => {
            map.invalidateSize();
        }, 100);
    }

    main();
});
