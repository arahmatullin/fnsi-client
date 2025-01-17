package ru.inovus.util.fnsi.client.service.api.dto.query;

import javax.validation.constraints.Min;
import java.util.Map;

public abstract class PageableQueryDto extends IdentifiableQueryDto implements FieldValueBuilder {
    /**
     * Номер страницы.
     */
    @Min(value = 1L, message = "Page number must be greater than zero")
    protected int page;
    /**
     * Количество элементов на странице.
     */
    @Min(value = 1L, message = "Size number must be greater than zero")
    protected int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> buildFieldValueMap() {
        Map<String, String> built = super.buildFieldValueMap();
        built.put("page", String.valueOf(page));
        built.put("size", String.valueOf(size));
        return built;
    }
}
