# Java Sorting Algorithms with GUI

Welcome to the Java Sorting Algorithms repository! This project features three classic sorting algorithms implemented in Java, complemented by a graphical user interface (GUI) for visualizing the sorting process. The included algorithms are Bubble Sort, Merge Sort, and Quick Sort. This tool is perfect for educational purposes, helping users to understand the intricacies of these sorting algorithms through interactive visualizations.

## Overview

This project aims to provide a hands-on understanding of sorting algorithms by visualizing their operations step-by-step. Users can select an algorithm, generate a random array, and watch the algorithm sort the array in real-time. The GUI allows for interactive learning and comparison of the sorting algorithms.

## Features

- **Interactive GUI**: Real-time visualization of sorting processes.
- **Multiple Sorting Algorithms**: Includes Bubble Sort, Merge Sort, and Quick Sort.
- **Customization Options**: Users can adjust the speed of visualization and the size of the array.
- **Educational Tool**: Ideal for students and educators to understand sorting algorithms.

## Screenshots

Here are some screenshots of the application in action:

<h2>Screenshots</h2>
<div style="display: flex;">
  <img src="res/images/screenshot1.png" alt="Sorting Visualization 1" width="300" style="margin-right: 10px;">
  <img src="res/images/screenshot2.png" alt="Sorting Visualization 2" width="300" style="margin-right: 10px;">
  <img src="res/images/screenshot3.png" alt="Sorting Visualization 3" width="300">
</div>

## Technologies Used

- **Java**: Core programming language used.
- **Swing**: For building the graphical user interface.
- **Maven**: For project management and dependency management.

## Installation

To get started with the application, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/java-sorting-algorithms.git
   cd java-sorting-algorithms
   ```

2. **Open the project in your favorite IDE**: Open the project folder in an IDE like IntelliJ IDEA, Eclipse, or NetBeans.

3. **Build the project using Maven**:
   ```bash
   mvn clean install
   ```

4. **Run the application**: Locate the main class (`Main.java`) and run it.

## Usage

1. **Select a Sorting Algorithm**: Choose from Bubble Sort, Merge Sort, or Quick Sort.
2. **Generate Array**: Click the "Generate Array" button to create a random array.
3. **Start Sorting**: Press the "Start" button to begin the visualization.
4. **Adjust Speed**: Use the slider to control the speed of the visualization.
5. **Pause/Resume**: Use the "Pause" button to pause the visualization and "Resume" to continue.

## Code Structure

- `src/main/java`: Contains the main Java source code.
  - `gui`: Contains classes related to the graphical user interface.
    - `MainFrame.java`: The main window of the application.
    - `ControlPanel.java`: The panel with controls for the sorting algorithms.
  - `sorting`: Contains classes implementing the sorting algorithms.
    - `BubbleSort.java`
    - `MergeSort.java`
    - `QuickSort.java`
- `src/main/resources`: Contains resources such as images and styles.
- `pom.xml`: Maven configuration file.

## Future Enhancements

- **Additional Algorithms**: Implement and visualize more sorting algorithms such as Insertion Sort, Selection Sort, and Heap Sort.
- **Enhanced Visualization**: Add more detailed animations to illustrate key steps in the algorithms.
- **User Input**: Allow users to input their own arrays for sorting.
- **Comparative Analysis**: Provide side-by-side visual comparison of two or more sorting algorithms.

## Contributing

Contributions are welcome! If you have any improvements, bug fixes, or new features in mind, feel free to fork the repository and submit a pull request. You can also open an issue for bug reports or feature requests.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a pull request

## License

This project is licensed under the [MIT License](LICENSE). See the LICENSE file for details.

---

Thank you for checking out my project! Enjoy visualizing and learning about sorting algorithms!
