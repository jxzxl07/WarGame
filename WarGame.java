

import java.util.*;

public class WarGame {

    public static void main(String[] args) {
        // Create deck of 2-14 values * 4 suits (suits ignored in logic)
        List<Integer> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int r = 2; r <= 14; r++) {
                deck.add(r);
            }
        }

        Collections.shuffle(deck);

        // Each player gets 26 cards
        Queue<Integer> player = new LinkedList<>();
        Queue<Integer> cpu = new LinkedList<>();

        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) player.add(deck.get(i));
            else cpu.add(deck.get(i));
        }

        System.out.println("Welcome to War! Press Enter to play a round...");

        try (Scanner sc = new Scanner(System.in)) {
            int rounds = 0;
            int MAX_ROUNDS = 20;

            while (!player.isEmpty() && !cpu.isEmpty() && rounds < MAX_ROUNDS) {
                sc.nextLine();
                rounds++;

            int pCard = player.poll();
            int cCard = cpu.poll();

            System.out.println("You draw: " + pCard);
            System.out.println("CPU draws: " + cCard);

            if (pCard > cCard) {
                player.add(pCard);
                player.add(cCard);
                System.out.println("You win the round!");
            } else if (cCard > pCard) {
                cpu.add(pCard);
                cpu.add(cCard);
                System.out.println("CPU wins the round!");
            } else {
                // Simplified — CPU wins ties
                cpu.add(pCard);
                cpu.add(cCard);
                System.out.println("It's a tie! CPU takes the cards!");
            }

            System.out.println("You: " + player.size() + " cards | CPU: " + cpu.size() + " cards");
            System.out.println();
        }

        System.out.println("Game over after " + rounds + " rounds!");

        if (player.size() > cpu.size()) {
            System.out.println("You win the game!");
        } else if (cpu.size() > player.size()) {
            System.out.println("CPU wins the game!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}

}


