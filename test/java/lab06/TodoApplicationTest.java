
package lab06;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import java.util.List;

class TodoApplicationTest {

    private TodoApplication todoApp;
    private PersonService personServiceMock;
    private TodoService todoServiceMock;

    private final String userName = "SomeUser";
    private final Long userID = 1L;
    private final List<String> todos = List.of("Wake up", "Test the code", "Celebrate the victory!");

    @Test
    void addTodo() {
        // Ensure that it's possible to add a todo to the app, and that the correct methods are called
        // Dummy objects into constructor
        // 2 interfaces = 2 mocks
        todoServiceMock = mock(TodoService.class);
        personServiceMock = mock(PersonService.class);
        todoApp = new TodoApplication(todoServiceMock, personServiceMock);   //todoApp is using the interfaces in its constructor
        // promoting to stub (hard coded answer to method)
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);  // hard coded answer (ID input gives Name output) here 1L -> SomeUser
        when(todoServiceMock.addTodo(anyString(),anyString())).thenReturn(Boolean.TRUE); // hard coded answer (2 Strings input gives true always)
        assertThat(todoApp.addTodo(userID,"Rest")).isTrue();  // based on line 33 hard coded answer, it must be true
        // promoting to mock (verifying behaviour)
        verify(personServiceMock).findUsernameById(userID);
        verify(todoServiceMock).addTodo(anyString(),anyString());
        verify(personServiceMock, times(1)).findUsernameById(userID);
        verify(todoServiceMock, times(1)).addTodo(anyString(),anyString());
    }

    @Test
    void retrieveTodos() {
        // add multiple todos to the app, and retrieve a strict subset of them using a substring.
        todoServiceMock = mock(TodoService.class);
        personServiceMock = mock(PersonService.class);
        todoApp = new TodoApplication(todoServiceMock, personServiceMock);   //todoApp is using the interfaces in its constructor
        // promoting to stub (hard coded answer to method)
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);  // hard coded answer
        when(todoServiceMock.retrieveTodos(userName)).thenReturn(todos); // hard coded answer
        assertThat(todoApp.retrieveTodos(userID, "Wake")).containsExactlyInAnyOrder("Wake up");  // only checking todoApp
        // promoting to mock (verifying behaviour)
        verify(personServiceMock).findUsernameById(userID);
        verify(todoServiceMock).retrieveTodos(userName);
        verify(personServiceMock, times(1)).findUsernameById(userID);
        verify(todoServiceMock, times(1)).retrieveTodos(userName);
    }

    @Test
    void completeAllWithNoTodos() {
        // confirm that the appropriate behaviour occurs when there are no todos being tracked by the app
        todoServiceMock = mock(TodoService.class);
        personServiceMock = mock(PersonService.class);
        todoApp = new TodoApplication(todoServiceMock, personServiceMock);   //todoApp is using the interfaces in its constructor
        // promoting to stub (hard coded answer to method)
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);  // hard coded answer
        when(todoServiceMock.addTodo(anyString(),anyString())).thenReturn(Boolean.TRUE);
        doNothing().when(todoServiceMock).completeTodo(anyString());
        todoApp.completeAllTodos(userID);
        // promoting to mock
        verify(personServiceMock, times(1)).findUsernameById(userID);
        verify(todoServiceMock,times(1));

    }

    @Test
    void completeAllWithThreeTodos() {
        // confirm that the appropriate behaviour occurs when there are three todos being tracked by the app
        todoServiceMock = mock(TodoService.class);
        personServiceMock = mock(PersonService.class);
        todoApp = new TodoApplication(todoServiceMock, personServiceMock);   //todoApp is using the interfaces in its constructor
        // promoting to stub (hard coded answer to method)
        when(personServiceMock.findUsernameById(userID)).thenReturn(userName);  // hard coded answer
        when(todoServiceMock.addTodo(anyString(),anyString())).thenReturn(Boolean.TRUE);
        doNothing().when(todoServiceMock).completeTodo(anyString());
        todoApp.addTodo(userID,"Wake");
        todoApp.addTodo(userID,"Happy");
        todoApp.addTodo(userID,"Sad");
        todoApp.completeAllTodos(userID);
        // promoting to mock
        verify(personServiceMock, times(4)).findUsernameById(userID);
        verify(todoServiceMock,times(4));
    }
}