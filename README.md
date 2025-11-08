# CrunchHub

A cloud-native platform for indie game developers to publish their games and participate in game jams.

## What is CrunchHub?

CrunchHub is a platform designed for the indie game development community. Whether it's a solo developer looking to share their latest creation or a team wanting to join game jams.

## Features

- **Game Publishing**: Upload and share games with the community
- **Game Jams**: Participate in themed development challenges and events
- **Cloud-Native Architecture**: Built for scalability and reliability
- **Containerized Deployment**: Deploy and manage across different environments

## Tech Stack

- **Backend**: Spring Boot (Java 17)
- **Database**: PostgreSQL
- **Containerization**: Docker
- **CI/CD**: GitHub Actions
- **Registry**: GitHub Container Registry (ghcr.io)
- **Security**: Automated vulnerability scanning with Trivy and Grype

## Current Status

This is an active work-in-progress. The platform currently includes:
- Core service architecture
- Database integration
- Automated testing (unit & integration)
- Container image building and publishing
- Security scanning pipeline
- More features coming soon

## Getting Started

### Prerequisites
- Java 17 or higher
- Docker
- PostgreSQL

### Running Locally
```bash
# Clone the repository
git clone https://github.com/carlosem23/catalog-service.git

# Build the project
./gradlew build

# Run tests
./gradlew test

# Build container image
./gradlew bootBuildImage
```

## CI/CD Pipeline

The project uses GitHub Actions for continuous integration and deployment:
- Automated code vulnerability scanning
- Unit and integration testing
- Container image building
- Security scanning of container images
- Automated publishing to GitHub Container Registry (on main branch)

## Contributing

This is a personal learning project, but suggestions and feedback are always welcome! Feel free to open an issue if something could be improved.

---

Building a home for indie game developers, one commit at a time
