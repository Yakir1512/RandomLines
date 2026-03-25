# Random Lines OOP Project

## Overview
This project showcases various object-oriented programming (OOP) concepts through a collection of classes and methods that generate random lines of different types.

## Features
- **Random Line Generator**: Generates random strings based on specified criteria.
- **Customizable Parameters**: Users can specify the length, character types, and formats of the generated lines.
- **Multiple Formats**: Supports generation of lines in various formats (e.g., JSON, XML).

## Installation
To install the project, clone the repository and navigate into the project directory:
```bash
git clone https://github.com/Yakir1512/RandomLines.git
cd RandomLines
```

## Usage
To use the Random Line Generator:
```python
from random_lines import RandomLineGenerator

generator = RandomLineGenerator()
random_line = generator.generate(length=10, chars='letters')
print(random_line)
```

## Classes
### RandomLineGenerator
- **Methods**:
  - `generate(length, chars)`: Generates a random line based on the specified length and character options.

## Contributing
Feel free to submit issues or pull requests if you would like to contribute to this project.

## License
This project is licensed under the MIT License.