package com.example.schedulerapp.db;

import com.example.schedulerapp.exceptions.BadIdException;
import com.example.schedulerapp.exceptions.ResourceNotFoundException;
import com.example.schedulerapp.task_service.ScheduledTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@SpringBootTest
class DBServiceJPATest {
    @Autowired
    private DBService dbService;

    @MockBean
    private Repository repository;

    @Test
    public void test_findAll_OK() {
        ScheduledTask expectedScheduledTask = new ScheduledTask();
        expectedScheduledTask.setId(1L);
        expectedScheduledTask.setName("test");
        expectedScheduledTask.setRecurrency("*/10 * * * * *");
        expectedScheduledTask.setCode("println \"Hello\"");

        List<ScheduledTask> expected = Collections.singletonList(expectedScheduledTask);
        when(repository.findAll()).thenReturn(Collections.singletonList(expectedScheduledTask));

        assertEquals(expected, dbService.findAll());
    }

    @Test
    public void test_findAll_Empty() {

        List<ScheduledTask> expected = Collections.emptyList();
        when(repository.findAll()).thenReturn(Collections.emptyList());

        assertEquals(expected, dbService.findAll());
    }

    @Test
    public void test_findById_OK() {
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setId(1L);
        scheduledTask.setName("test");
        scheduledTask.setRecurrency("*/10 * * * * *");
        scheduledTask.setCode("println \"Hello\"");

        when(repository.findById(1L)).thenReturn(Optional.of(scheduledTask));

        assertEquals(Optional.of(scheduledTask), dbService.findById(1L));
    }

    @Test
    public void test_findById_Not_Found() {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(null));

        assertEquals(Optional.ofNullable(null), dbService.findById(1L));
    }

    @Test
    public void test_delete_Not_Found() {
        doThrow(new EmptyResultDataAccessException(1)).when(repository).deleteById(1L);

        RuntimeException exception = assertThrows(ResourceNotFoundException.class, () -> dbService.delete(1L));

        String expectedMessage = "Resource with id=1 not found";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void test_save_OK() {

        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setName("test");
        scheduledTask.setRecurrency("*/10 * * * * *");
        scheduledTask.setCode("println \"Hello\"");

        ScheduledTask expectedScheduledTask = new ScheduledTask();
        expectedScheduledTask.setId(1L);
        expectedScheduledTask.setName("test");
        expectedScheduledTask.setRecurrency("*/10 * * * * *");
        expectedScheduledTask.setCode("println \"Hello\"");

        when(repository.save(scheduledTask)).thenReturn(expectedScheduledTask);

        assertEquals(expectedScheduledTask, dbService.saveScheduledTask(scheduledTask));
    }

    @Test
    public void test_saveList_OK() {
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setName("test");
        scheduledTask.setRecurrency("*/10 * * * * *");
        scheduledTask.setCode("println \"Hello\"");

        ScheduledTask expectedScheduledTask = new ScheduledTask();
        expectedScheduledTask.setId(1L);
        expectedScheduledTask.setName("test");
        expectedScheduledTask.setRecurrency("*/10 * * * * *");
        expectedScheduledTask.setCode("println \"Hello\"");

        List<ScheduledTask> list = Collections.singletonList(scheduledTask);
        List<ScheduledTask> expectedList = Collections.singletonList(expectedScheduledTask);

        when(repository.saveAll(list)).thenReturn(expectedList);

        assertEquals(expectedList, dbService.saveScheduledTasks(list));
    }

    @Test
    public void test_update_OK() {

        Long id = 1L;

        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setId(id);
        scheduledTask.setName("test");
        scheduledTask.setRecurrency("*/10 * * * * *");
        scheduledTask.setCode("println \"Hello\"");

        when(repository.existsById(id)).thenReturn(true);
        when(repository.save(scheduledTask)).thenReturn(scheduledTask);

        assertEquals(scheduledTask, dbService.update(id, scheduledTask));
    }

    @Test
    public void test_update_Not_Found() {

        Long id = 1L;

        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setId(id);
        scheduledTask.setName("test");
        scheduledTask.setRecurrency("*/10 * * * * *");
        scheduledTask.setCode("println \"Hello\"");

        RuntimeException exception = assertThrows(ResourceNotFoundException.class, () -> dbService.update(1L, scheduledTask));

        String expectedMessage = "Resource with id=1 not found";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void test_update_BadId() {
        Long id = 1L;

        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.setId(2L);
        scheduledTask.setName("test");
        scheduledTask.setRecurrency("*/10 * * * * *");
        scheduledTask.setCode("println \"Hello\"");

        RuntimeException exception = assertThrows(BadIdException.class, () -> dbService.update(1L, scheduledTask));
    }
}