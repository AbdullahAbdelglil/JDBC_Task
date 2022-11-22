package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {
    SingleToneConnection myConnection = SingleToneConnection.getInstance();

    @Nested
    @DisplayName("Connection should fail because ")
    class ConnectionParameterTest {

        @Test
        @DisplayName("Url is incorrect")
        void urlShouldBeIncorrect() {
            assertThrows(RuntimeException.class, () -> {
                myConnection.connectToDatabase("jdbc:mysql://localhost:3316/jdbctask", "student", "Abdullah2002");
            });
        }

        @Test
        @DisplayName("user name is incorrect")
        void userNameShouldBeIncorrect() {
            assertThrows(RuntimeException.class, () -> {
                myConnection.connectToDatabase("jdbc:mysql://localhost:3306/jdbctask", "employee", "Abdullah2002");
            });
        }

        @Test
        @DisplayName("password is incorrect")
        void passWordShouldBeIncorrect() {
            assertThrows(RuntimeException.class, () -> {
                myConnection.connectToDatabase("jdbc:mysql://localhost:3306/jdbctask", "student", "Abdullah2020");
            });
        }

        @Test
        void databaseShouldBeConnectedSuccessfully() {
            myConnection.connectToDatabase("jdbc:mysql://localhost:3306/jdbctask", "student", "Abdullah2002");
            assertEquals(true,myConnection.connected);
        }
    }
}