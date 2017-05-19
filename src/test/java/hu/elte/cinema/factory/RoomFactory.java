package hu.elte.cinema.factory;

import hu.elte.cinema.dao.interfaces.RoomDao;
import hu.elte.cinema.model.Room;
import hu.elte.cinema.model.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RoomFactory extends AbstractFactory<Room> {


    public RoomFactory(RoomDao dao) {
        super(dao);
    }

    @Override
    public Room createOne(Object... arguments) {
        Room room = new Room();
        room.setMaxColumnNumber(new Random().nextInt(20));
        room.setMaxRowNumber(new Random().nextInt(20));
        room.setRoomName(UUID.randomUUID().toString());
        room.setOccupied(new ArrayList<>());
        room.setSeats(createSeats(room.getMaxRowNumber(), room.getMaxColumnNumber()));
        return room;
    }

    private List<Seat> createSeats(int row, int column) {
        List<Seat> result = new ArrayList<>();
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < column; ++j) {
                Seat seat = new Seat();
                seat.setReserved(false);
                seat.setX(i);
                seat.setY(j);
                result.add(seat);
            }
        }
        return result;
    }
    public void updateRoom(Room room) {
        getDao().updateEntity(room);
    }
}
