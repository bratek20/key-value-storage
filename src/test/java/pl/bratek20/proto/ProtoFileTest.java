package pl.bratek20.proto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProtoFileTest {
    private static ProtoFile<TestProto.File> file;

    @BeforeAll
    static void createFile() {
        var data = TestProto.File.newBuilder()
            .setSomeMessage(TestProto.SomeMessage.newBuilder()
                .setId(1)
            )
            .addSomeMessages(TestProto.SomeMessage.newBuilder()
                .setId(1)
            )
            .build();

        file = new ProtoFile<>(data, TestProto.File.getDescriptor());
    }

    @Test
    void shouldGetField() {
        var field = file.get("someMessage", TestProto.SomeMessage.class);

        assertThat(field.getId()).isEqualTo(1);
    }

    @Test
    void shouldGetRepeatedField() {
        var list = file.getList("someMessages", TestProto.SomeMessage.class);

        assertThat(list).hasSize(1);
        assertThat(list.get(0).getId()).isEqualTo(1);
    }
}