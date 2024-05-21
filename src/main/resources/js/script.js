        document.getElementById('loginForm').addEventListener('submit', function(event) {
            event.preventDefault();

            const apiUrl = 'http://localhost:8080/login/logged';
            const login = document.getElementById('floatingInput').value;
            const password = document.getElementById('floatingPassword').value;

            const user = {
                login: login,
                password: password
            };

            fetch(apiUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                const jwtToken = data.token;
                localStorage.setItem('jwtToken', jwtToken);
                location.href = "http://localhost:8080/nav-bar.html"
            })
            .catch(error => {
                console.error('Error:', error);
            });
        });
