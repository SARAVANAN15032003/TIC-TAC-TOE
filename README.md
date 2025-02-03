# Tic Tac Toe (Rolling XO Game) 🎮
This is a simple **Tic Tac Toe** game implemented in Java using **Swing** for the graphical user interface (GUI). The game allows two players to take turns and play on a 3×3 grid.

## Features
- **Two-player gameplay** (X and O players take turns).
- **Graphical User Interface (GUI)** using Java Swing.
- **Dynamic Move Management**:
  - Each player can only have 3 active marks at a time.
  - Once a player places a fourth mark, the oldest mark is removed automatically.
- **Win and Draw Detection**:
  - The game checks for winning conditions after each move.
  - If all spots are filled and no one wins, it's declared a draw.
- **Interactive Buttons**:
  - Players click on buttons to place their marks.
  - Buttons are automatically disabled after selection to prevent overwriting.
  
## Technologies Used
- **Java** (Core logic)
- **Swing** (GUI development)
- **Queue Data Structure** (Manages active moves for each player)

## How to Run the Project
1. **Clone the Repository**
   ```sh
   git clone https://github.com/SARAVANAN15032003/tic-tac-toe-java.git
   cd tic-tac-toe-java
   ```
2. **Compile the Java File**
   ```sh
   javac XO.java
   ```
3. **Run the Application**
   ```sh
   java XO
   ```

## Game Rules
- The game is played on a **3×3 grid**.
- Players **take turns** to place their mark (**X or O**) in an empty cell.
- A player can only have **3 active marks** at any time.
- If a player places a **fourth mark**, their **oldest mark is removed** automatically.
- A player **wins** if they align **3 of their marks** in a row, column, or diagonal.
- If the board is full and no one wins, the game is a **draw**.

## Screenshot
![image](https://github.com/user-attachments/assets/ab196180-f276-4dd3-9608-8725c78a7090)
![image](https://github.com/user-attachments/assets/062e452f-ccaf-4501-9afb-147fc96d9e19)
![image](https://github.com/user-attachments/assets/3096a114-9368-49fb-b22d-918873636462)




## License
This project is open-source and available under the [MIT License](LICENSE).

---
Enjoy the game! 🎮

